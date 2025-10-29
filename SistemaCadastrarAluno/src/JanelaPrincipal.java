import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {
    private JTextField campoNome, campoEmail, campoRua, campoCidade;
    private JComboBox<String>comboCurso;
    private JCheckBox checkEmail, checkNotificacao;
    private JRadioButton radioMasc, radioFem;
    private JButton btnCadastrar, btnLimpar, btnSair;

    public JanelaPrincipal(){
        setTitle("Sistema de Cadastro de Alunos");
        setSize(500,400);
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
        itemSobre.addActionListener(e-> JOptionPane.showMessageDialog(this,"Sisyema de Cadastro de Alunos\nversão 1.0"));
        menuAjuda.add(itemSobre);

        barra.add(menuArquivo);
        barra.add(menuAjuda);
        setMenuBar(barra);

        // Abas
        JTabbedPane abas = new JTabbedPane();

        // Painel Dados Pessoais
        JPanel painelDados = new JPanel(new GridLayout(6,2));
        painelDados.add(new JLabel("Nome:"));
        campoNome = new JTextField(20);
        painelDados.add(campoNome);

        painelDados.add(new JLabel("Email"));
        campoEmail = new JTextField(20);
        painelDados.add(campoEmail);

        painelDados.add(new JLabel("Curso"));
        String[] cursos = {"java", "Python","C#", "JavaScript"};
        comboCurso = new JComboBox<>(cursos);
        painelDados.add(comboCurso);

        painelDados.add(new JLabel("Genero"));
        JPanel painelGenero = new JPanel();
        radioMasc = new JRadioButton("Masculino");
        radioMasc = new JRadioButton("Feminino");

        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(radioMasc);
        grupoGenero.add(radioFem);
        painelGenero.add(radioMasc);
        painelGenero.add(radioFem);
        painelDados.add(pain)

    }
}

