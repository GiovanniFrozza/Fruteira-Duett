import React, { useState, useEffect } from 'react';
import { Modal, FloatingLabel, Form, Button } from 'react-bootstrap';
import { findById, divisao, multiplicacao } from '../services/frutas'

export default function ResultadoModal(props) {
  const [fruta, setFruta] = useState();
  const [resultado, setResultado] = useState(0);
  const {idFruta ,openModal, setOpenModal} = props

  useEffect( () => {
    findFrutaById();
  }, [idFruta]);

  const findFrutaById = async() => {
    const res = await findById(idFruta);
    setFruta(res.data);
  }

  const divide = async() => {
    const res = await divisao(idFruta);
    setResultado(res.data);
  }

  const multiplica = async() => {
    const res = await multiplicacao(idFruta);
    setResultado(res.data);
  }

  const handleClose = () => {
    setOpenModal(false)
    setResultado(0);
  }

  return fruta && (
    <>
      <Modal
        size="lg"
        show={openModal}
        onHide={handleClose}
        aria-labelledby="example-modal-sizes-title-lg" >

        <Modal.Header closeButton>
          <Modal.Title id="example-modal-sizes-title-lg">
            Selecionar
          </Modal.Title>
        </Modal.Header>

        <Modal.Body>
          <FloatingLabel
            controlId="floatingInput"
            label="Descrição"
            className="mb-3"  
          >
            <Form.Control type="text" value={fruta?.descricao} disabled/>
          </FloatingLabel>

          <FloatingLabel
            controlId="floatingInput"
            label="Valor A"
            className="mb-3"  
          >
            <Form.Control type="text" value={fruta?.valorA} disabled/>
          </FloatingLabel>

          <FloatingLabel
            controlId="floatingInput"
            label="Valor B"
            className="mb-3"  
          >
            <Form.Control type="text" value={fruta?.valorB} disabled/>
          </FloatingLabel>

          <FloatingLabel
            controlId="floatingInput"
            label="Resultado"
            className="mb-3"  
          >
            <Form.Control type="text" value={resultado} disabled/>
          </FloatingLabel>

          <div style={{display:"flex", justifyContent:"space-evenly"}}>
            <Button className="w-25" onClick={divide}>
              Divisao
            </Button>

            <Button className="w-25" onClick={multiplica}>
              Multiplicacao
            </Button>
          </div>
        </Modal.Body>
      </Modal>
    </>
  );
}
