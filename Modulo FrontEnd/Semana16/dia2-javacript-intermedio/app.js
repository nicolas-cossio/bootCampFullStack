console.log('Hola JS')

const numero = 339
const cadena = 'Victor'
const esMayor = true
let undefinedValue
const soyNulo = null

// Arrays
let listaDeValores = []
console.log(listaDeValores)

listaDeValores = [1,2,3, 'Victor', 'Villazón', esMayor, numero, undefinedValue, soyNulo]
console.log(listaDeValores)

console.log(listaDeValores[0])
console.log(listaDeValores[4])
console.log(listaDeValores)

// Método de Arreglos
const languages = ['javascript', 'java', 'php', 'python', 'C', 'c++', 'python']

// Método Includes: Nos indica si el valor que se pasa como parámetro se enuentra en el arreglo y devuelve true o false
console.log(languages.includes('java'))
console.log(languages.includes('cobol'))

// Método filter: Nos ayuda a ubicar un elemento dentro de un arreglo usando una condición y devuelve un arreglo con los resultados
const resultado = languages.filter(
    function(language) {
        return language.includes('c')
    }
)
console.log(resultado)

// Objectos 
// key: value
let miObjeto = {
    nombre: 'Victor',
    apellido: 'Villazón',
    colorFavorito: 'azul',
    coloresFavoritos: ['rosado', 'azul', 'rojo'],
    edad: 33,
}
console.log(miObjeto)

// Eliminar una propiedad de un objeto
delete miObjeto.colorFavorito
console.log(miObjeto)

// Agregar una propiedad a un objeto
miObjeto.genero = 'masculino'
console.log(miObjeto)

// Destructuring
// Una forma de extraer las propiedades/elementos de un objeto o un arreglo en nuevas variables

// Destructuring para Objetos
const nombreValue = miObjeto.nombre
const apellidoValue = miObjeto.apellido
const edadValue = miObjeto.edad
console.log(nombreValue, apellidoValue, edadValue)

const { nombre, apellido, edad } = miObjeto
console.log(nombre, apellido, edad)

const { nombre: nombreValor, apellido: apellidoValor } = miObjeto
console.log(nombreValor, apellidoValor)

// Destructuring para Arreglos
const amigos = ['axl', 'david', 'jose', 'julio', 'victor']
const [amigo1, amigo2, , , amigo3] = amigos
console.log(amigo1, amigo2, amigo3)