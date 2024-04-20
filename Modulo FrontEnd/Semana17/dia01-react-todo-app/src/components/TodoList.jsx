const TodoList = ({todos, onCompleted, onRemoveTodo}) => {
    return (
        <ul className="flex flex-col gap-2">
          {todos?.map(todo => {
            return (
              <li className="flex" key={todo.id}>
                <input 
                  className='mr-2' 
                  type='checkbox'
                  data-id={todo.id}
                  onChange={onCompleted}
                  checked={todo.completed}
                />
                <div className='w-full flex justify-between items-center'>
                  <span className={todo.completed ? 'line-through' : ''}>
                    {todo.text}
                  </span>
                  <button 
                    className="bg-red-400 rounded-lg px-3 py-1"
                    data-id={todo.id}
                    onClick={onRemoveTodo}
                  >
                    X
                  </button>
                </div>
              </li>
            )
          })}
        </ul>
    )
}

export default TodoList