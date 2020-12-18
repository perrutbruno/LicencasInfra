import {http} from './config';

export default {
    listar: () => {
        return http.get('usuario-ms/api/usuarios')
    },
    alterar:(idUsuario, usuario) => {
        return http.put(`usuario-ms/api/usuarios/${idUsuario}`, usuario)
    },
    salvar:(usuario) => {
        return http.post('usuario-ms/api/usuarios', usuario)
    },
    excluir:(usuario) => {
        return http.delete("usuario-ms/api/usuarios/" + usuario.idUsuario)
    }
}