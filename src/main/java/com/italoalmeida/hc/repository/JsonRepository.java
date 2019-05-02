package com.italoalmeida.hc.repository;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.italoalmeida.hc.exception.repository.GravacaoArquivoJsonException;
import com.italoalmeida.hc.exception.repository.LeituraArquivoJsonException;

/**
 * @author Italo Almeida
 * 
 * Responsável pela definição de leituras e gravações em arquivos de texto no formato JSON
 *
 * @param <MODEL>
 */
public interface JsonRepository<MODEL> {
	
	final String EXTENSAO = ".json";
	
	/**
	 * @return lista contida no arquivo JSON especificado
	 * @throws GravacaoArquivoJsonException 
	 * @throws LeituraArquivoJsonException 
	 */
	default List<MODEL> ler(String caminhoArquivo, String nomeArquivo) 
			throws LeituraArquivoJsonException {
		
		// Intancia conversor JSON
		Gson conversorJson = new GsonBuilder().setPrettyPrinting().create();
		
		// Compõe o nome do arquivo com as informações necessárias para leitura
		String nomeCompletoArquivo = caminhoArquivo + nomeArquivo + EXTENSAO;
		
		try (FileReader arquivo = new FileReader(nomeCompletoArquivo)){
			
			Type tipo = new TypeToken<List<MODEL>>(){}.getType();

			return conversorJson.fromJson(arquivo, tipo);
			
		} catch (Exception e) {
			throw new LeituraArquivoJsonException();
		}
	};

	/**
	 * @param Conteúdo que será gravado em um novo arquivo JSON
	 * @throws LeituraArquivoJsonException 
	 * @throws GravacaoArquivoJsonException 
	 */
	default void gravar(MODEL model, String caminhoArquivo, String prefixoArquivo) 
			throws GravacaoArquivoJsonException {		

		// Intancia conversor JSON
		Gson conversorJson = new GsonBuilder().setPrettyPrinting().create();
		
		// Compõe o nome do arquivo com as informações necessárias para gravação
		String nomeCompletoArquivo = caminhoArquivo + prefixoArquivo + System.currentTimeMillis() + EXTENSAO;
		
		try (FileWriter arquivo = new FileWriter(nomeCompletoArquivo)) {
			
			arquivo.write(conversorJson.toJson(model));
			arquivo.flush();
			
		} catch (Exception e) {
			throw new GravacaoArquivoJsonException();
		}
	}

}
