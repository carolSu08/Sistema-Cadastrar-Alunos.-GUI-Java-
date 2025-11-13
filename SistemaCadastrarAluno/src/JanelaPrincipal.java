// exemplo 2 //

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class JanelaPrincipal extends JFrame {
    private JTextField campoNome, campoEmail, campoRua, campoCidade;
    private JComboBox<String> comboCurso;
    private JCheckBox checkEmail, checkNotificacao;
    private JRadioButton radioMasc, radioFem;
    private JButton btnCadastrar, btnLimpar;

    private JTable tabela;
    private DefaultTableModel modeloTabela;

    public JanelaPrincipal(){
        setTitle("Sistema de Cadastro de Alunos");
        setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu
        JMenuBar barra = new JMenuBar();
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem itemSair = new JMenuItem("Sair");
        itemSair.addActionListener(e->System.exit(0));
        menuArquivo.add(itemSair);

        JMenu menuAjuda = new JMenu("Ajuda");
        JMenuItem itemSobre = new JMenuItem("Sobre");
        itemSobre.addActionListener(e-> JOptionPane.showMessageDialog(this,"Sisyema de Cadastro de Alunos\nCRUD Completo\n versão 2.0"));
        menuAjuda.add(itemSobre);

        barra.add(menuArquivo);
        barra.add(menuAjuda);
        setMenuBar(barra);

        // Abas
        JTabbedPane abas = new JTabbedPane();

        // Painel Dados Pessoais
        JPanel painelCadastro = new JPanel(new GridLayout(7,2));
        painelCadastro.add(new JLabel("Nome:"));
        campoNome = new JTextField(20);
        painelCadastro.add(campoNome);

        painelCadastro.add(new JLabel("Email"));
        campoEmail = new JTextField(20);
        painelCadastro.add(campoEmail);

        painelCadastro.add(new JLabel("Curso"));
        String[] cursos = {"java", "Python","C#", "JavaScript"};
        comboCurso = new JComboBox<>(cursos);
        painelCadastro.add(comboCurso);

        painelCadastro.add(new JLabel("Genero"));
        JPanel painelGenero = new JPanel();
        radioMasc = new JRadioButton("Masculino");
        radioMasc = new JRadioButton("Feminino");
        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(radioMasc);
        grupoGenero.add(radioFem);
        painelGenero.add(radioMasc);
        painelGenero.add(radioFem);
        painelCadastro.add(painelGenero);

        checkEmail = new JCheckBox("Receber emails");
        checkNotificacao = new JCheckBox("Ativar notificações");
        painelCadastro.add(checkEmail);
        painelCadastro.add(checkNotificacao);

        abas.add("Dados Pessoais", painelDados);

        // Painel Endereço
        JPanel painelEndereco = new JPanel(new GridLayout(2,2));
        painelEndereco.add(new JLabel("Rua:"));
        campoRua = new JTextField(20);
        painelEndereco.add(campoRua);
        painelEndereco.add(new JLabel("Cidade:"));
        campoCidade = new JTextField(20);
        painelEndereco.add(campoCidade);
        abas.add("Endereço", painelEndereco);

        // Botões
        JPanel painelBotoes = new JPanel();
        btnCadastrar = new JButton("Cadastrar");
        btnLimpar = new JButton("Limpar");
        btnSair = new JButton("Sair");
        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnLimpar);
        painelBotoes.add(btnSair);

        // Ações dos botões
        btnCadastrar.addActionListener(e -> cadastrarAluno());
        btnLimpar.addActionListener(e -> limparCampos());
        btnSair.addActionListener(e -> System.exit(0));

        // Layout principal
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(abas, BorderLayout.CENTER);
        getContentPane().add(painelBotoes, BorderLayout.SOUTH);
        setVisible(true);
    }
    private void cadastrarAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome(campoNome.getText());
        aluno.setEmail(campoEmail.getText());

        aluno.setCurso((String) comboCurso.getSelectedItem());
        aluno.setGenero(radioMasc.isSelected() ? "Masculino" : "Feminino");
        aluno.setReceberEmail(checkEmail.isSelected());
        aluno.setReceberNotificacao(checkNotificacao.isSelected());
        aluno.setRua(campoRua.getText());
        aluno.setCidade(campoCidade.getText());
        JOptionPane.showMessageDialog(this,
                "Aluno cadastrado com sucesso:\n" +
                        "Nome: " + aluno.getNome() + "\n" +
                        "Email: " + aluno.getEmail() + "\n" +
                        "Curso: " + aluno.getCurso() + "\n" +
                        "Gênero: " + aluno.getGenero() + "\n" +
                        "Rua: " + aluno.getRua() + "\n" +
                        "Cidade: " + aluno.getCidade());

        private void cadastrarAluno(){
            Aluno aluno1 = new Aluno();
            aluno.setNome(campoNome.getText());
            aluno.setEmail(campoEmail.getText());
            aluno.setCurso((String) comboCurso.getSelectedItem());
            aluno.setGenero(radioMasc.isSelected() ? "Masculino" : "Feminino");
            aluno.setReceberEmail(checkEmail.isSelected());
            aluno.setReceberNotificacao(checkNotificacao.isSelected());
            aluno.setRua(campoRua.getText());
            aluno.setCidade(campoCidade.getText());

            AlunoDAO dao = new AlunoDAO();
            dao.salvar(aluno);

            JOptionPane.showMessageDialog(this,"Aluno cadastrado com sucesso no banco de dados!");
        }
    }
    private void limparCampos() {
        campoNome.setText("");
        campoEmail.setText("");
        comboCurso.setSelectedIndex(0);
        radioMasc.setSelected(false);
        radioFem.setSelected(false);
        checkEmail.setSelected(false);
        checkNotificacao.setSelected(false);
        campoRua.setText("");
        campoCidade.setText("");
    }
    public static void main(String[] args) {
        new JanelaPrincipal();
    }
}

