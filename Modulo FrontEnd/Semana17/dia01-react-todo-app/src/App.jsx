import { useState } from 'react'

function App() {
  const DEFAULT_TODOS = [
    { id: 1, text: 'Learn React.js', completed: true },
    { id: 2, text: 'Learn CSS', completed: false },
    { id: 3, text: 'Learn JS', completed: false },
  ]

  const [todos, setTodos] = useState(DEFAULT_TODOS)
  const [input, setInput] = useState('')

  

  const handleSubmit = (event) => {
    event.preventDefault()
    console.log('Formulario enviado')
  }

  return (
    <main
      className="bg-yellow-100 w-full max-w-sm mx-auto mt-10 border border-yellow-600
      rounded-lg shadow-lg p-4">
      <h1 className="text-2xl font-bold text-center">Todo App</h1>

      {/* {JSON.stringify(todos)} */}
      <form onChange={handleSubmit}>
        <input
          className="w-full border my-3 p-3"
          type="text"
          placeholder="¿Qué deseas hacer hoy?"
          required
        />
      </form>

      <div className="flex justify-between items-center">
        <span className="font-bold"> 2 de 3</span>
        <button className="bg-blue-500 rounded-lg px-2 py-1 text-white hover:bg-blue-700 duration-300"
        >Limpiar tareas completadas</button>
      </div>

      <section className="mt-8">
        <ul className="flex flex-col gap-2">
          {todos.map((todo => {
            return (
              <li
              key={todo.id}
              className="flex justify-between items-center bg-white p-2 rounded-lg shadow-md"
            >
              <span>{todo.text}</span>
              <button
                className="bg-red-500 rounded-lg px-2 py-1 text-white hover:bg-red-700 duration-300"
              >
                X
              </button>
            </li>
            )
            })
          )}

        </ul>
      </section>
    </main>
  )
}

export default App
