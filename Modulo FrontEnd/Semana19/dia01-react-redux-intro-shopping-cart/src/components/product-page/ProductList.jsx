import { useEffect, useState } from "react"
import ProductItem from "./ProductItem"
import { fetchProducts } from "../../services/products"

const ProductList = () => {
  const [productList, setProductList] = useState([])

  useEffect(() => {
    fetchProducts()
      .then(setProductList)
  }, [])
  
  return (
    <div className="grid grid-cols-2 md:grid-cols-4 gap-8">
      {productList.map(
        product => <ProductItem
          key={product.id}
          product={product}
        />
      )}
      
      {/* {JSON.stringify(productList)} */}
    </div>
  )
}

export default ProductList