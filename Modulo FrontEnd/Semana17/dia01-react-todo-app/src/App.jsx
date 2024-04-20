import { useState } from 'react'
import Header from './components/Header'
import TodoList from './components/TodoList'
import Stats from './components/Stats'

const App = () => {
  const DEFAULT_TODOS = [
    { id: '1', text: 'Learn React.js', completed: false },
    { id: '2', text: 'Learn CSS', completed: true },
    { id: '3', text: 'Learn JS', completed: false }
  ]

  const [todos, setTodos] = useState(DEFAULT_TODOS)
  const [input, setInput] = useState('')

  const handleChange = (event) => {
    const value = event.target.value
    setInput(value)
  }

  const handleSubmit = (event) => {
    // Previene que se actualice la pagina tras el submit del form
    event.preventDefault();
    // Se accede al valor del input
    const newTodo = {
      id: crypto.randomUUID(),
      text: input,
      completed: false
    }
    // Se agrega el nuevo todo a la lista de todos
    setTodos([...todos, newTodo])
    // Se limpia la caja despues de enviar
    setInput('')
  }

  const handleRemoveTodo = (event) => {
    // Se guarda el id enviado desde el boton.
    const idSelected = event.target.dataset.id
    // Se elimina el id del arreglo
    const newTodos = todos.filter(todo => todo.id !== idSelected)
    setTodos(newTodos)
  }

  const handleCheckBox = (event) => {
    const idSelected = event.target.dataset.id
    const isChecked = event.target.checked
    // Actualizamos el estado del elementos seleccionado
    const newTodos = todos.map(todo => {
      if (todo.id === idSelected) {
        return { ...todo, completed: isChecked }
      }
      return todo
    })

    setTodos(newTodos)
  }

  const completedTodos = todos.filter(todo => todo.completed).length
  const totalTodos = todos.length

  const handleLimpiarTodos = (event) => {
    const incompletedTasks = todos.filter(todo => !todo.completed)
    setTodos(incompletedTasks)
  }

  return (
    <main
      className="bg-yellow-100 w-full max-w-sm mx-auto mt-10 border border-yellow-600
      rounded-lg shadow-lg p-4">

      <Header />

      <form className="flex items-center gap-2" onSubmit={handleSubmit}>
        <input
          className="w-full border my-3 p-3"
          type="text"
          placeholder="¿Qué deseas hacer hoy?"
          required
          onChange= {handleChange}
          value={input}
        />
        <input
          className="bg-blue-300 font-bold rounded-lg px-2 py-2 cursor-pointer"
          type='submit'
          value='Añadir'
        />
      </form>

      {todos.length > 0 && ( 
        <Stats 
          completedTodos = {completedTodos}
          totalTodos = {totalTodos}
          onLimpiarTodo = {handleLimpiarTodos}
        />
      )} 

      <section className="mt-8">
        <TodoList
          todos = {todos}
          onCompleted = {handleCheckBox}
          onRemoveTodo = {handleRemoveTodo}
        />
      </section>
    </main>
  )
}

export default App
