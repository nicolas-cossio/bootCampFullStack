import React from 'react'

const Stats = ({completedTodos, totalTodos, onLimpiarTodo}) => {
  return (
    <div className='flex justify-between items-center'>
          <span className='font-bold'>{completedTodos} de {totalTodos}</span>
          <button
            className='bg-blue-500 rounded-lg px-2 py-1 text-white hover:bg-blue-600 duration-300'
            onClick={onLimpiarTodo}
          >
            Limpiar tareas completadas
          </button>
        </div>
  )
}

export default Stats