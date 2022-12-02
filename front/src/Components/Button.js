import React, { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import Table from 'react-bootstrap/Table';

export default function ResultadoModal() {
  const [lgShow, setLgShow] = useState(false);

  return (
    <>
      <Button onClick={() => setLgShow(true)}>
        Selecionar
      </Button>
      
      <Modal
        size="lg"
        show={lgShow}
        onHide={() => setLgShow(false)}
        aria-labelledby="example-modal-sizes-title-lg" >

        <Modal.Header closeButton>
          <Modal.Title id="example-modal-sizes-title-lg">
            Selecionar
          </Modal.Title>
        </Modal.Header>

        <Modal.Body>

        </Modal.Body>
      </Modal>
    </>
  );
}
