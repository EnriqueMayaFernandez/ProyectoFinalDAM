import { Genero } from '../genero';

export interface Serie{
  id?:string;
  nombreSerie?:string;
  rutaImagenSerie?:string;
  director?:string;
  fechaEmision?:string;
  fechaFinalizacion?:string;
  numeroCapitulos?:string;
  genero?:Genero;
}
