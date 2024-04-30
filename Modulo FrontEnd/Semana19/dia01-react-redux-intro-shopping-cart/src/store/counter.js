import { createSlice } from "@reduxjs/toolkit"

const config = {
  name: 'counter',
  initialState: 0,
  reducers: {
    increment: (state) => {
      return state+1
    },
    decrement: (state) => state-1,
    incrementByValue: (state, action) => state+action.payload
  }
}

export const counterSlice = createSlice(config)
// Exportando el estado inicial y los reducers del slice
export default counterSlice.reducer 

// Hace referencia a las acciones (elementos de reducers)
export const { increment, decrement, incrementByValue } = counterSlice.actions
  
