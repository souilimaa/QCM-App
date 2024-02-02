import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import QcmCard from './qcmCard';
import '../css/allqcms.css';

function ListQcm() {
  const [qcms, setQcms] = useState([]);
  const { id, nom } = useParams();

  useEffect(() => {
    fetch(`http://localhost:8080/Qcm/qcms/getByMatiereId/${id}`)
      .then((res) => res.json())
      .then((data) => {
        setQcms(data);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }, [id, nom]);

  return (
    <div className='myContainer'>
      <h1>QCM/Quiz {nom}</h1>

      {qcms.length === 0 ? (
        <div>Il n'y a pas encore de QCMs pour ce sujet.</div>
      ) : (
        <div className='QcmCard'>
          {qcms.map((qcm) => (
            <div key={qcm.id}>
              <QcmCard qcm={qcm} />
            </div>
          ))}
        </div>
      )}
    </div>
  );
}

export default ListQcm;
