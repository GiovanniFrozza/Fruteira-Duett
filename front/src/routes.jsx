import React from "react";
import Frutas from "./pages/PaginaFrutas"
import Teste from "./pages/Teste.jsx"
import { createBrowserRouter, RouterProvider, Route } from "react-router-dom";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Frutas />,
  },
]);

const Rotas = () => {
  return(
    <React.StrictMode>    
      <RouterProvider router={router} />  
    </React.StrictMode>
  )
}

export default Rotas;