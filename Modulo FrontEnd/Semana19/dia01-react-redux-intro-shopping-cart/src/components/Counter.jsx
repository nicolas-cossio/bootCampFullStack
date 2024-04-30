import { useSelector, useDispatch } from "react-redux"

import { increment, decrement, incrementByValue} from "../store/counter"

export default function Counter() {
  const counter = useSelector(state => state.counter)
  const dispath = useDispatch()

  const handleIncrement = () => dispath(increment())
  const handleDecrement = () => dispath(decrement())
  const handleIncremetByValue = () => dispath(incrementByValue(10))
  const handleDecrementByValue = () => dispath(incrementByValue(-10))


  return (
    <div className="flex flex-col items-center bg-[#CD8D7A] p-4">
      <h3 className="text-3xl">Counter with Redux</h3>

      <div className="flex items-center gap-4 mt-4">
        <button
          className="p-3 bg-green-500 rounded-lg"
          onClick={handleDecrementByValue}
        >
          -10
        </button>
        <button
          className="p-3 bg-green-500 rounded-lg"
          onClick={handleDecrement}
        >
          -1
        </button>
        <span className="font-bold text-4xl">{counter}</span>
        <button
          className="p-3 bg-green-500 rounded-lg"
          onClick={handleIncrement}
        >
          +1
        </button>
        <button
          className="p-3 bg-green-500 rounded-lg"
          onClick={handleIncremetByValue}
        >
          +10
        </button>
      </div>
    </div>
  ) 
}