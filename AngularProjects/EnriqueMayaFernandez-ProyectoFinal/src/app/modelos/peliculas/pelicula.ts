import { Genero } from '../genero';

export interface Pelicula{
    id?:string;
    nombrePelicula?:string;
    director?:string;
    fechaEmision?:string;
    duracion?:string;
    genero?:Genero
}
