import React from 'react';
import ReactDOM from 'react-dom';
import axios from 'axios';

import NewItemRegisterComponent from './new_item_register_component.jsx'


const ClientTableComponent = React.createClass({

    getInitialState: function () {
        return {
            clients: []
        }
    },

    componentDidMount: function () {
        axios.get('http://localhost:8080/api/clients')
            .then(res => {
                const clients = res.data;
                this.setState({ clients });
            });
    },

    render: function () {
        return (
            <div>
                <h2><label>List of clients</label></h2>
                <table className="table">
                    <thead>
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Birth date</th>
                            <th>Phone number</th>
                            <th>Client type</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.clients.map(client =>
                            <tr key={client.id}>
                                <td>{client.firstName}</td>
                                <td>{client.lastName}</td>
                                <td>{client.birthDate}</td>
                                <td>{client.phoneNumber}</td>
                                <td>{client.clientType}</td>
                                <td><input className="btn btn-primary" id="registerBtn" type="button" value="Register"
                                /></td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
        );
    }
});

export default ClientTableComponent;
