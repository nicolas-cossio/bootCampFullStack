import React, { useState } from 'react'

const AppointmentsForm = ({ onSaveAppointment}) => {
  const INITIAL_FORM_STATE = {
    id: '',
    petName: '',
    petAge: '',
    ownerName: '',
    appointmentDate: '',
    appointmentTime: '',
    symptoms: '',
  }

  const [form, setForm] = useState(INITIAL_FORM_STATE)

  const handleChange = (event) => {
    const { name, value } = event.target
    setForm({ ...form, [name]: value })
  }

  const handleSaveAppointment = (event) => {
    event.preventDefault()

    const newAppointment = {
      ...form,
      id: crypto.randomUUID()
    }

    onSaveAppointment(newAppointment)
    setForm(INITIAL_FORM_STATE)
  }

  return (
    <section className="w-96 p-4">
      <h2 className='text-2xl text-center mb-4'>Nuevo Paciente</h2>

      <pre>{JSON.stringify(form, null, 2)}</pre>

      <form 
        className='flex flex-col gap-4'
        onSubmit={handleSaveAppointment}
      >
        <input 
          type='text'
          name='petName'
          placeholder='Nombre de mi mascota'
          className='border p-3 shadow-md rounded-md'
          onChange={handleChange}
          value={form.petName}
        />
        <input 
          type='number'
          name='petAge'
          placeholder='Edad de mi mascota'
          className='border p-3 shadow-md rounded-md'
          onChange={handleChange}
          value={form.petAge}
        />
        <input 
          type='text'
          name='ownerName'
          placeholder='Dueño de la mascota'
          className='border p-3 shadow-md rounded-md'
          onChange={handleChange}
          value={form.ownerName}
        />
        <input 
          type='date'
          name='appointmentDate'
          placeholder='Fecha de la cita'
          className='border p-3 shadow-md rounded-md'
          onChange={handleChange}
          value={form.appointmentDate}
        />
        <input 
          type='time'
          name='appointmentTime'
          placeholder='Hora de la cita'
          className='border p-3 shadow-md rounded-md'
          onChange={handleChange}
          value={form.appointmentTime}
        />
        <textarea
          name='symptoms'
          placeholder='Síntomas'
          className='border p-3 shadow-md rounded-md'
          rows='5'
          onChange={handleChange}
          value={form.symptoms}
        >
        </textarea>
        <input 
          type='submit'
          className='border p-2 bg-green-800 text-white rounded-md cursor-pointer'
          value='Guardar'
        />
      </form>
    </section>
  )
}

export default AppointmentsForm