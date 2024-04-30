import React, { useState } from 'react'
import AppointmentsForm from '../components/appointments/AppointmentsForm'
import AppointmentsList from '../components/appointments/AppointmentsList'


const Appointments = () => {
  const INITIAL_APPOINTMENTS = [
  ]


  const [appointments, setAppointments] = useState(INITIAL_APPOINTMENTS)

  const handleSaveAppointment = (form) => {
    setAppointments([...appointments, form])
  }

  const handleRemove = (appointment) => {
    const id = appointment.id

    const newAppointments = appointments.filter(
      appointment => appointment.id !== id
    )
  }

  return (
    <>
        <AppointmentsForm 
          onSaveAppointment={handleSaveAppointment}
        />
        <AppointmentsList 
          appointments={appointments}
        />    
    </>
  )
}

export default Appointments