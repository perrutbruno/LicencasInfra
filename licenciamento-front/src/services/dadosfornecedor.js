import {http} from './config';

export default {
    listar: () => {
        return http.get('fornecedor-ms/api/fornecedores')
    },
    alterar:(idFornecedor, fornecedor) => {
        return http.put(`fornecedor-ms/api/fornecedores/${idFornecedor}`, fornecedor)
    },
    salvar:(fornecedor) => {
        return http.post('fornecedor-ms/api/fornecedores', fornecedor)
    },
    excluir:(fornecedor) => {
        return http.delete("fornecedor-ms/api/fornecedores/" + fornecedor.idFornecedor)
    }
}