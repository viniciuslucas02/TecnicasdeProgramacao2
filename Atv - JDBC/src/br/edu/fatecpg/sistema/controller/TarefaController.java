package br.edu.fatecpg.sistema.controller;
import br.edu.fatecpg.sistema.model.Banco;
import br.edu.fatecpg.sistema.model.Tarefa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TarefaController {
    public String inserirTarefa(int id, String nm_tarefa, boolean status, String categoria) {
        String query = "INSERT INTO tabela(id, nm_tarefa, status, categoria) VALUES(?,?,?,?)";
        try (var conexao = Banco.conectar()) {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setString(2, nm_tarefa);
            stmt.setBoolean(3, status);
            stmt.setString(4, categoria);
            stmt.execute();
            return "Gravado com sucesso";

        } catch (Exception e) {
            return e.getMessage();
        }

    }
    public String selecionarTarefa(){
        String query = "SELECT * FROM tabela";
        List<Tarefa> tarefas= new ArrayList<>();
        try (var conexao = Banco.conectar()) {
            PreparedStatement stmt = conexao.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tarefas.add(new Tarefa(rs.getInt(1),
                        rs.getString("nm_tarefa"),
                        rs.getBoolean("status"),
                        rs.getString("categoria")));

            }
            return tarefas.toString();
        } catch (Exception e) {
            return e.getMessage();
        }

    }
    public String deletarTarefa(int id){
        String query = "DELETE FROM tabela WHERE id = ?";
        try (var conexao = Banco.conectar()) {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return "Deletado com sucesso";
        }catch (Exception e){
            return e.getMessage();
        }

    }
    public String editarTarefa(int id, String nm_tarefa, boolean status, String categoria) {
        String query = "UPDATE tabela SET nm_tarefa = ?, status = ?, categoria = ? WHERE id = ?";
        try (var conexao = Banco.conectar()) {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, nm_tarefa);
            stmt.setBoolean(2, status);
            stmt.setString(3, categoria);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            return "Editado com sucesso";
        }catch (Exception e){
        return e.getMessage();
    }
    }

    public String atualizarStatus(int id, boolean status) {
        String query = "UPDATE tabela SET status = true, WHERE = ?";
        try (var conexao = Banco.conectar()) {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setBoolean(1, status);
            stmt.setInt(2, id);
            return "Editado com sucesso";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String listarCategoria(String categoria){
        String query = "SELECT * FROM tabela WHERE categoria = ?";
        List<Tarefa> tarefas= new ArrayList<>();
        try (var conexao = Banco.conectar()) {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, categoria);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tarefas.add(new Tarefa(rs.getInt(1),
                        rs.getString("nm_tarefa"),
                        rs.getBoolean("status"),
                        rs.getString("categoria")));

            }
            return tarefas.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    public String ListarStatus(boolean status){
        String query = "SELECT * FROM tabela WHERE status = ?";
        List<Tarefa> ts = new ArrayList<>();
        try(var conexao = Banco.conectar()) {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setBoolean(1, status);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                ts.add(new Tarefa(rs.getInt("id"),
                        rs.getString("nm_tarefa"),
                        rs.getBoolean("status"),
                        rs.getString("categoria")));

            }
            return ts.toString();
        } catch (Exception e){
            return e.getMessage();
        }
    }
}

