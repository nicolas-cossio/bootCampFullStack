import { configureStore } from "@reduxjs/toolkit"

import counterReducer from './counter'
import counter from "./counter"

export const store = configureStore({
  reducer: {
    counter: counterReducer,  
  }
})