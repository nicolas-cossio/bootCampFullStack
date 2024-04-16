import Saludo from './components/Saludo.jsx'
import Despedida from './components/Despedida.jsx'

import { LISTA_DE_FRUTAS, EDAD } from './components/frutas.js'

function App() {
  const nombre = 'Victor'
  return (
    <>
      <h1>Hola React!</h1>
      <p>Estoy en el bootcamp!</p>

      {/* Comentario en react dentro de JSX */}
      <Saludo />
      <Despedida />
      {1 + 2}

      {`Hola ${nombre}!`}

      {LISTA_DE_FRUTAS.map((fruta, index) => (
        <p key={index}>{fruta}</p>
      ))}
      {EDAD}

    </>
    
  )
}

export default App
