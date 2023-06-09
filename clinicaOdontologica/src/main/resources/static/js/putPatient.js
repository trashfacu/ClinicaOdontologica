window.addEventListener('load', function(){
    const form = document.querySelector('#updateFormPaciente')
    form.addEventListener('submit', function(event){
        event.preventDefault();
        const formData={
            id: document.getElementById('formId').value,
            dni: document.getElementById('formDni').value,
            nombre: document.getElementById('formNombre').value,
            apellido: document.getElementById('formApellido').value
        }

        const url = '/patients'
        const settings = {
            method:'PUT',
            headers:{
                'Content-Type': 'application/json'
            },
            body:JSON.stringify(formData)
        }
        fetch(url, settings)
        .then(response=>response.json())
        .then(data => {
            alert('Patient updated');
            document.getElementById('updateFormPaciente').reset();
        })
        .catch(error => {
            alert('ERROR: '+error)
        })
    })
})
