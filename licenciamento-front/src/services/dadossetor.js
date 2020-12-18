import {http} from './config';

export default {
    listar: () => {
        return http.get('setor-ms/api/setores')
    },
    alterar:(idSetor, setor) => {
        return http.put(`setor-ms/api/setores/${idSetor}`, setor)
    },
    salvar:(setor) => {
        return http.post('setor-ms/api/setores', setor)
    },
    excluir:(setor) => {
        return http.delete("setor-ms/api/setores/" + setor.idSetor)
    }
}