import React, { useEffect, useState } from 'react';
import { findAll } from '../services/frutas';
import { Table, Button } from 'react-bootstrap';
import Titulo from '../Components/Titulo';
import ResultadoModal from '../Components/ResultadoModal';

const PaginaFrutas = () => {
  const [openModal, setOpenModal] = useState(false);
  const [frutas, setFruta] = useState([]);
  const [idFruta, setIdFruta] = useState();
  
  useEffect( () => {
    findAllFrutas();
  }, []);

  const findAllFrutas = async() => {
    const res = await findAll();
    setFruta(res.data);
  }

  const handleClick = (id) => {
    setOpenModal(true)
    setIdFruta(id)
  }

  return (
    <React.Fragment>
      <Titulo />

      <div className="container">
        <div className="row">
          <Table striped>
            <thead>
              <tr>
                <th>Descrição</th>
                <th>A</th>
                <th>B</th>
                <th>Ação</th>
              </tr>
            </thead>
            <tbody>
            {frutas?.map(fruta => (
                <tr key={fruta.id}>
                  <td>{fruta.descricao}</td>
                  <td>{fruta.valorA}</td>
                  <td>{fruta.valorB}</td>
                  <td>
                    <Button onClick={() => handleClick(fruta.id)}>
                      Selecionar
                    </Button>
                  </td>
                </tr>
            ))}
            </tbody>
          </Table>
        </div>
      </div>

      {idFruta && (
          <ResultadoModal 
          idFruta={idFruta}
          openModal={openModal} 
          setOpenModal={setOpenModal}
        />
      )}
      
    </React.Fragment>
  );
}

export default PaginaFrutas