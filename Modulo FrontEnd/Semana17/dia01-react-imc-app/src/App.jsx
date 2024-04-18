import { useState } from "react"

function App() {
  const [weight, setWeight] = useState(20)
  const [height, setHeight] = useState(0)

  const handleWeight = (event) => {
    setWeight(event.target.value)
  }
  
  const handleHeight = (event) => {
    setHeight(event.target.value)
  }

  const bodyMassIndex = weight / (height / 100) ** 2

  const bodyMassIndexState = () => {
    let result = ''
    if (bodyMassIndex < 18.5) {
      result = 'Bajo peso'
    } else if (bodyMassIndex >= 18.5 && bodyMassIndex < 24.9) {
      result = 'Peso normal'
    } else if (bodyMassIndex >= 24.9 && bodyMassIndex < 29.9) {
      result = 'Sobrepeso'
    } else if (bodyMassIndex >= 29.9){
      result = 'Obesidad'
    }

    return result
  }
  
  return (
    <section>
      <h1 className="text-3xl font-bold underline">IMC Calculator</h1>
      <div>
        <p>Weight: {weight} kg</p>
        <input 
          type="range" 
          min="50" 
          max="200"
          onChange={handleWeight}
        />
      </div>

      <div>
        <p>Height: {height} cm</p>
        <input 
          type="range" 
          min="50" 
          max="200" 
          onChange={handleHeight}/>
      </div>

      <div>
        <p>IMC: {bodyMassIndex.toFixed(2)}</p>
      </div>

      <p>
        Estado de IMC: {bodyMassIndexState()}
      </p>
    </section>
    
  )
}

export default App
