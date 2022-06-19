import { Rol } from './rol';

export interface Usuario {
    id?:string;
    nombreUsuario?:string;
    clave?:string;
    rol?:Rol;
}
