async function deletePatient(id) {
    const url = `/patients/${id}`;
    const settings = {
        method: 'DELETE'
    };
    try {
        const response = await fetch(url, settings);
        const data = await response.json();
        console.log(data);
        let idFila = 'paciente_' + id;
        document.getElementById(idFila).remove();
    } catch (error) {
        console.error(error);
    }
}
