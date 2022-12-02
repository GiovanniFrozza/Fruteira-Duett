import React, { Component } from 'react';
import FrutaApi from './Api/FrutaApi';
import Table from 'react-bootstrap/Table';
import Titulo from './Components/Titulo';
import Button from './Components/Button';

class App extends Component {
  state = {
    frutas: [],
  }

  async componentDidMount() {
    const response = await FrutaApi.get('');
    this.setState({ frutas: response.data });
  }

  render() {

    const { frutas } = this.state;

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
              {frutas.map(fruta => (
                <tbody>
                  <tr>
                    <td>{fruta.descricao}</td>
                    <td>{fruta.valorA}</td>
                    <td>{fruta.valorB}</td>
                    <td>
                      <Button />
                    </td>
                  </tr>
                </tbody>
              ))}
            </Table>
          </div>
        </div>

      </React.Fragment>
    );
  }
}

export default App;