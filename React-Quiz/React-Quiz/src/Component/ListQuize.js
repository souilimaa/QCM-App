import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom'; 
import '../css/ListQuize.css';
import NavbarAdmin from '../Component/NavbarAdmin';

const ListQuize = () => {
  const [matieres, setMatieres] = useState([]);
  const [selectedMatiere, setSelectedMatiere] = useState(null);
  const [qcmTitles, setQcmTitles] = useState([]);

 
  useEffect(() => {
    const fetchMatieres = async () => {
      try {
        const response = await fetch('http://localhost:8080/Qcm/matieres/all');
        if (!response.ok) {
          throw new Error(`Failed to fetch matieres: HTTP status ${response.status}`);
        }
        const data = await response.json();
        setMatieres(data);
      } catch (error) {
        console.error('Error fetching matieres:', error.message);
      }
    };

    fetchMatieres();
  }, []);

useEffect(() => {
    const fetchQcmTitles = async () => {
      if (selectedMatiere) { 
        try {
          const apiUrl = `http://localhost:8080/Qcm/qcms/getByMatiereId/${selectedMatiere._id}`;
          console.log("API URL:", apiUrl);

          const response = await fetch(apiUrl);
          if (!response.ok) {
            throw new Error(`Failed to fetch QCM titles: HTTP status ${response.status}`);
          }
          const data = await response.json();

          console.log("Received QCM Titles:", data);
          setQcmTitles(data);
        } catch (error) {
          console.error('Error fetching QCM titles:', error);
        }
      } else {
        console.log("Aucune matiere selected");
      }
    };

    fetchQcmTitles();
  }, [selectedMatiere])
  
  const handleMatiereChange = (event) => {
    const selectedName = event.target.value;
    console.log("Selected Name:", selectedName);
  
    const selected = matieres.find(m => m.nom === selectedName);
    setSelectedMatiere(selected);
  
    if (selected) {
      console.log("Selected Matiere:", selected);
    } else {
      console.log("Matiere not found");
    }
  };
  

  return (
    <div>
      <NavbarAdmin />
      <h1>QCM List</h1>
      <label htmlFor="matiereSelect">Select Matiere: </label>
      <select id="matiereSelect" onChange={handleMatiereChange}>
        <option value="">Select Matiere</option>
        {matieres.map(matiere => (
          <option key={matiere._id} value={matiere._id}>{matiere.nom}</option>
        ))}
      </select>

      {qcmTitles.length > 0 && (
        <div>
          <h2>QCM Titles for {selectedMatiere ? selectedMatiere.nom : 'selected Matiere'}</h2>
          <ul>
            {qcmTitles.map(qcm => (
              <li key={qcm._id}>
                <Link to={`/qcmdetails/${qcm._id}`}>{qcm.titre}</Link>
              </li>
            ))}
          </ul>
        </div>
      )}
    </div>
  );
};

export default ListQuize;