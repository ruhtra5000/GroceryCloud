package br.com.grocerycloud.grocerycloud.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grocerycloud.grocerycloud.dados.IRepositorioAquisicao;
import br.com.grocerycloud.grocerycloud.negocio.colecoes.IColecaoAquisicao;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Aquisicao;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.aquisicoes.AquisicaoNaoEncontradaException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.aquisicoes.CnpjInvalidoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.aquisicoes.CnpjNaoEncontradoException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.aquisicoes.AquisicaoNaoEncontradaException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.aquisicoes.CnpjNaoEncontradoException;

import java.util.InputMismatchException;
import java.util.List;

/**
 * Esta classe implementa as ações e as regras de negocio relacionadas a uma
 * aquisição.
 * 
 * @author Arthur de Sá Tenório
 * @category Classe de negocio da aplicação
 */

@Service
public class NegocioAquisicao implements IColecaoAquisicao {
    @Autowired
    private IRepositorioAquisicao repositorioAquisicao;

    @Override
    public void adicionar(Aquisicao aquisicao) throws CnpjInvalidoException {
        if(!verificarCNPJ(aquisicao.getCnpjFornecedor()))
            throw new CnpjInvalidoException();
        repositorioAquisicao.save(aquisicao);
    }

    @Override
    public List<Aquisicao> listarTodos() {
        return repositorioAquisicao.findAllByOrderById();
    }

    @Override
    public Aquisicao listarPorId(long id) throws AquisicaoNaoEncontradaException {
        Aquisicao aquisicao = repositorioAquisicao.findById(id);
        if (aquisicao == null)
            throw new AquisicaoNaoEncontradaException();
        return aquisicao;
    }

    @Override
    public List<Aquisicao> listarPorCNPJ(String cnpj) throws CnpjNaoEncontradoException {
        List<Aquisicao> aquisicoes = repositorioAquisicao.findAllByCnpjFornecedor(cnpj);
        if (aquisicoes.isEmpty())
            throw new CnpjNaoEncontradoException();
        return aquisicoes;
    }

    @Override
    public boolean verificarCNPJ(String cnpj) {
        
		cnpj = removerCaracteresEspeciais(cnpj);
		
		// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
		if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
        cnpj.equals("22222222222222") || cnpj.equals("33333333333333") || 
        cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
        cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || 
        cnpj.equals("88888888888888") || cnpj.equals("99999999999999") || 
        (cnpj.length() != 14))
			return (false);

		char dig13, dig14;
		int sm, i, r, num, peso;

		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 2;
			for (i = 11; i >= 0; i--) {
				// converte o i-ésimo caractere do CNPJ em um número:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posição de '0' na tabela ASCII)
				num = (int) (cnpj.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig13 = '0';
			else
				dig13 = (char) ((11 - r) + 48);

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 2;
			for (i = 12; i >= 0; i--) {
				num = (int) (cnpj.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig14 = '0';
			else
				dig14 = (char) ((11 - r) + 48);

			// Verifica se os dígitos calculados conferem com os dígitos informados.
			if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException err) {
			return (false);
		}
    }

    private String removerCaracteresEspeciais(String cnpj) {
		if (cnpj.contains(".")) {
			cnpj = cnpj.replace(".", "");
		}
		if (cnpj.contains("-")) {
			cnpj = cnpj.replace("-", "");
		}
		if (cnpj.contains("/")) {
			cnpj = cnpj.replace("/", "");
		}
		return cnpj;
	}
}
