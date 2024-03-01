package br.com.grocerycloud.grocerycloud.negocio;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grocerycloud.grocerycloud.dados.IRepositorioAquisicao;
import br.com.grocerycloud.grocerycloud.dados.IRepositorioProduto;
import br.com.grocerycloud.grocerycloud.dados.IRepositorioProdutoAvariado;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoDashboard;
import br.com.grocerycloud.grocerycloud.negocio.entidade.ProdutoAvariado;

@Service
public class NegocioDashboard implements IColecaoDashboard {

    @Autowired
    IRepositorioProdutoAvariado repositorioAvariados;

    @Autowired
    IRepositorioProduto repositorioProdutos;

    @Autowired
    IRepositorioAquisicao repositorioAquisicao;

    // Produtos Avariados
    @Override
    public long getQtdeTotalAvariados() {
        List<ProdutoAvariado> avariados = repositorioAvariados.findAll();
        long contagem = 0;

        if (!avariados.isEmpty())
            for (ProdutoAvariado avariado : avariados) {
                contagem += avariado.getQtdeAvariados();
            }

        return contagem;
    }

    @Override
    public List<Map<String, Object>> getProdutoMaisAvariado() {
        return repositorioAvariados.findMaiorOcorrenciaProdutoAvariado();
    }

    // Aquisições
    @Override
    public double getCustoTotalAquisicoes() {
        return repositorioAquisicao.getCustosTotais();
    }

    @Override
    public List<Map<String, Object>> getAquisicoesAgrupadas() {
        return repositorioAquisicao.findAllAquisicoesSumCustoGroupByCnpj();
    };

    @Override
    public List<Map<String, Object>> getProdutoMaisAdquirido() {
        return repositorioAquisicao.findAllProdutosQuantityGroupByNomeLimit1();
    };

}
