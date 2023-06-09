window.addEventListener('load', function(){

  const url = 'patients/list';
  const settings = {
    method: 'GET'
  }

  fetch(url,settings)
    .then(response => response.json())
    .then(patients => {
      const tableBody = document.getElementById('tablaPacientes').getElementsByTagName('tbody')[0];

      patients.forEach(paciente => {
        const row = tableBody.insertRow();
        row.id = `paciente_${paciente.id}`;

        const deleteButton = `<button id="btnBorrarId${paciente.id}" onclick="borrarId(${paciente.id})" class="btn btn-danger"> X </button>`;
        const updateButton = `<button id="btnUpdateId${paciente.id}" onclick="encontrarId(${paciente.id})" class="btn btn-primary">${paciente.id}</button>`;

        row.innerHTML = `
          <td>${updateButton}</td>
          <td>${paciente.nombre}</td>
          <td>${paciente.apellido}</td>
          <td>${paciente.dni}</td>
          <td>${deleteButton}</td>
        `;
      });
    });
});
