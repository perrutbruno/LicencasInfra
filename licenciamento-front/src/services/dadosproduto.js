import {http} from './config';

export default {
    listar: () => {
        return http.get('produto-ms/api/produtos')
    },
    alterar:(idProduto, produto) => {
        return http.put(`produto-ms/api/produtos/${idProduto}`, produto)
    },
    salvar:(produto) => {
        return http.post('produto-ms/api/produtos', produto)
    },
    excluir:(produto) => {
        return http.delete("produto-ms/api/produtos/" + produto.idProduto)
    }
}