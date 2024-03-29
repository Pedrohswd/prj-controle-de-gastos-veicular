/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.capycar.connection;

import com.capycar.view.HomeView;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class GastoRiderAPI {

    public static void main(String[] args) {
        String comando = "./src/DB/cargaInicial.sql";
        initBD(comando);
        HomeView home = new HomeView();
        home.setVisible(true);
    }

    public static void initBD(String comando) {
        try ( Connection connection = conectBD()) {
            System.out.println("Conexão bem-sucedida!");

            BufferedReader reader = new BufferedReader(new FileReader(comando));
            String line;
            StringBuilder script = new StringBuilder();

            // Concatena cada linha em um único script SQL
            while ((line = reader.readLine()) != null) {
                script.append(line);
                script.append("\n");
            }

            // Divide o script em várias instruções SQL separadas
            String[] statements = script.toString().split(";");

            // Executa cada instrução SQL
            for (String sql : statements) {
                if (!sql.trim().isEmpty()) {
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(sql);
                }
            }

            System.out.println("Scripts executados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Falha na conexão com o banco de dados: " + e.getMessage());
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de carga inicial não encontrado: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Falha ao ler o arquivo de carga inicial: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Connection conectBD() {
        Properties props = new Properties();
        Connection connection = null;
        try {
            FileInputStream in = new FileInputStream("src/DB/CFG_DB.txt");
            props.load(in);
            in.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo de propriedades: " + e.getMessage());
            return null;
        }

        String url = props.getProperty("url"); // obtém a URL de conexão a partir do arquivo de propriedades
        String user = props.getProperty("usuario"); // obtém o nome de usuário do banco de dados a partir do arquivo de propriedades
        String password = props.getProperty("senha"); // obtém a senha do banco de dados a partir do arquivo de propriedades
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Falha na conexão com o banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    public static boolean tabelaPossuiDados(String tabela) {
        boolean possuiDados = false;

        try {
            Connection connection = conectBD();
            // Preparar a consulta SQL
            String sql = "SELECT COUNT(*) FROM " + tabela;
            PreparedStatement statement = connection.prepareStatement(sql);

            // Executar a consulta
            ResultSet resultSet = statement.executeQuery();

            // Verificar se a tabela possui dados
            if (resultSet.next()) {
                int rowCount = resultSet.getInt(1);
                possuiDados = rowCount > 0;
            }

            // Fechar os recursos
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return possuiDados;
    }
}

//------------------------------Start 'Hard Test Insert'-------------------------------------//
//            String sqlInsert = "INSERT INTO carros (descricao, status) VALUES (?, ?)";;
//            PreparedStatement statement2 = connection.prepareStatement(sqlInsert);
//            statement2.setString(1, "Kombi");
//            statement2.setInt(2,1);
//
//            int rowsInserted = statement2.executeUpdate();
//            if (rowsInserted > 0) {
//                System.out.println("Registro inserido com sucesso!");
//            }
//------------------------------End 'Hard Test Insert'---------------------------------------//
//------------------------------Start 'Hard Test Get'----------------------------------------//
//            String sqlGet = "SELECT id, descricao, status FROM carros";
//            PreparedStatement statement1 = connection.prepareStatement(sqlGet);
//            ResultSet result = statement1.executeQuery();
//            
//              while (result.next()) {
//                long id = result.getLong("id");
//                String descricao = result.getString("descricao");
//                boolean status = result.getBoolean("status");
//
//                System.out.println("Carro ID: " + id + ", Descrição: " + descricao + ", Status: " + status);
//            }
//------------------------------End 'Hard Test Get'-----------------------------------------//
//------------------------------Start 'Hard Test Delete'------------------------------------//
//            String sqlDelete = "DELETE FROM carros WHERE id = ?";
//            PreparedStatement statement3 = connection.prepareStatement(sqlDelete);
//            statement3.setLong(1, 5L); // Valor do ID a ser excluído
//
//            int rowsDeleted = statement3.executeUpdate();
//            if (rowsDeleted > 0) {
//                System.out.println("Registro excluído com sucesso!");
//            } else {
//                System.out.println("Nenhum registro foi excluído.");
//            }
//------------------------------End 'Hard Test Delete'--------------------------------------//
//------------------------------Start 'Hard Test Update'------------------------------------//
//            String sqlUpdate = "UPDATE carros SET status = ? WHERE id = ?";
//            PreparedStatement statement = connection.prepareStatement(sqlUpdate);
//            statement.setInt(1, 0); // Novo valor do campo 'status'
//            statement.setLong(2, 2L); // Valor do ID do registro a ser atualizado
//
//            int rowsUpdated = statement.executeUpdate();
//            if (rowsUpdated > 0) {
//                System.out.println("Registro atualizado com sucesso!");
//            } else {
//                System.out.println("Nenhum registro foi atualizado.");
//            }
//------------------------------End 'Hard Test Update'--------------------------------------//

