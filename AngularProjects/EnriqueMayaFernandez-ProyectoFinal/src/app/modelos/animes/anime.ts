import { Genero } from '../genero';

export interface Anime {
  id?:string;
  nombreAnime?:string;
  estudioAnimacion?:string;
  fechaEmision?:string;
  fechaFinalizacion?:string;
  numeroCapitulos?:string;
  genero?:Genero;
}
