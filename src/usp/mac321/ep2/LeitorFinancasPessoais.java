package usp.mac321.ep2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorFinancasPessoais implements LeitorFinancasPessoaisDAO {
	
	public List<Usuario> leUsuarios(String nomeArquivoUsuarios) {
		List<Usuario> usersList = new ArrayList<>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(nomeArquivoUsuarios));
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				String[] lineVector = line.split(",");
				
				if (lineVector.length < 2) {
					reader.close();
					throw new MissingInformationException("Falta informações na planilha!");
				}
				
				if (!lineVector[0].equals("Apelido") && !lineVector[1].equals("Nome"))
					usersList.add(new Usuario(lineVector[0], lineVector[1]));
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return usersList;
	}
	
	public List<TipoDespesa>  leTiposDespesas(String nomeArquivoTiposDespesas) {
		List<TipoDespesa> expenseList = new ArrayList<>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(nomeArquivoTiposDespesas));
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				String[] lineVector = line.split(",");
				
				if (lineVector.length < 2) {
					reader.close();
					throw new MissingInformationException("Falta informações na planilha!");
				}
				
				if (!lineVector[0].equals("Categoria") && !lineVector[1].equals("SubCategoria"))
					expenseList.add(new TipoDespesa(lineVector[0], lineVector[1]));
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return expenseList;
	}
	
	public List<TipoReceita>  leTiposReceitas(String nomeArquivoTiposReceitas) {
		List<TipoReceita> revenueList = new ArrayList<>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(nomeArquivoTiposReceitas));
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				String[] lineVector = line.split(",");
				
				if (lineVector.length < 2) {
					reader.close();
					throw new MissingInformationException("Falta informações na planilha!");
				}
				
				if (!lineVector[0].equals("Categoria") && !lineVector[1].equals("SubCategoria"))
					revenueList.add(new TipoReceita(lineVector[0], lineVector[1]));
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return revenueList;
	}
	
	public List<Lancamento>   leLancamentos(String  nomeArquivoLancamentos) {
		List<Lancamento> launchList = new ArrayList<>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(nomeArquivoLancamentos));
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				String[] lineVector = line.split(",");
				
				if (lineVector.length < 7) {
					reader.close();
					throw new MissingInformationException("Falta informações na planilha!");
				}
				
				if (lineVector[5].startsWith("-")) {
					reader.close();
					throw new NegativeValueException("Valor não pode ser negativo!");
				}
				
				if (!lineVector[0].equals("ID")) {
					int id = Integer.parseInt(lineVector[0]);
					String data = lineVector[1]; String nickName = lineVector[2];
					boolean isExpense = lineVector[3].equalsIgnoreCase("true");
					String specificType = lineVector[4]; String description = lineVector[6];
					double value = Double.parseDouble(lineVector[5]);
					launchList.add(new Lancamento(id, data, nickName, isExpense, specificType, value, description));
				}
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return launchList;
	}
}
