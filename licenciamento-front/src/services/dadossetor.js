import {http} from './config';

export default {
    listar: () => {
        return http.get('setores')
    },
    alterar:(idSetor, setor) => {
        return http.put(`setores/${idSetor}`, setor)
    },
    salvar:(setor) => {
        return http.post('setores', setor)
    },
    excluir:(setor) => {
        return http.delete("setores/" + setor.idSetor)
    }
}