window.addEventListener('load', function(){
    const form = document.querySelector('#formAltaPaciente')

    form.addEventListener('submit', function(event){
        event.preventDefault()
        const formData = {
            dni: parseInt(document.getElementById('formDni').value),
            nombre: document.getElementById('formNombre').value,
            apellido: document.getElementById('formApellido').value
        }

        const url = '/pacientes/add'
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type':'application/json'
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
        .then(response=>response.json())
        .then(data=>{
            alert('Paciente agregado')
        })
        form.reset()
    })
})