package VidraFoz.Modelos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tela extends JFrame {
    private ArrayList<Produto> lista = new ArrayList<Produto>();
    private ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
    private float calcularTotalBase() {
        float total = 0;

        for (Produto item : lista) {
            total += item.getPreco() * item.getQnt();
        }

        return total;
    }

    public Tela() {
        JPanel principal = new JPanel(new BorderLayout(10,10));
        principal.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        JPanel formulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        //-----------Cliente-----------//
        gbc.gridx = 0; gbc.gridy = 0;
        formulario.add(new JLabel("ID Cliente"), gbc);

        gbc.gridx = 1;
        formulario.add(new JLabel("Nome Cliente"), gbc);

        gbc.gridx = 2;
        formulario.add(new JLabel("Endereco"), gbc);

        gbc.gridx = 3;
        formulario.add(new JLabel("Telefone"), gbc);

        gbc.gridx = 4;
        formulario.add(new JLabel("Email"), gbc);

        gbc.gridx = 5;
        formulario.add(new JLabel("CPF"), gbc);
        //--------------------------------------//

        //-----------Produto-------------//
        gbc.gridx = 0; gbc.gridy = 2;
        formulario.add(new JLabel("ID"), gbc);

        gbc.gridx = 1;
        formulario.add(new JLabel("Produto"), gbc);

        gbc.gridx = 2;
        formulario.add(new JLabel("Preco"), gbc);

        gbc.gridx = 3;
        formulario.add(new JLabel("Quantidade"), gbc);

        gbc.gridx = 4; gbc.gridy = 4;
        formulario.add(new JLabel("Desconto"), gbc);

        gbc.gridx= 5 ;
        formulario.add(new JLabel("Acrescimo"), gbc);
        //-------------------------------//

        //---------Cliente-----------//
        JTextField clienteId = new JTextField();
        JTextField clienteNome = new JTextField();
        JTextField clienteEndereco = new JTextField();
        JTextField clienteTelefone = new JTextField();
        JTextField clienteEmail = new JTextField();
        JTextField clienteCpf = new JTextField();
        //-------------------------------//

        //----------Produto------------//
        JTextField produtoId = new JTextField();
        JTextField produtoNome = new JTextField();
        JTextField produtoPreco = new JTextField();
        JTextField produtoQnt = new JTextField();

        JLabel totalLabel = new JLabel("Total de preços produtos: R$ 0.0");
        JTextField descontoField = new JTextField();
        JTextField acrescimoField = new JTextField();
        //------------------------//

        //----------Cliente----------//
        gbc.gridx = 0; gbc.gridy = 1;
        formulario.add(clienteId, gbc);

        gbc.gridx = 1;
        formulario.add(clienteNome, gbc);

        gbc.gridx = 2;
        formulario.add(clienteEndereco, gbc);

        gbc.gridx = 3;
        formulario.add(clienteTelefone, gbc);

        gbc.gridx = 4;
        formulario.add(clienteEmail, gbc);

        gbc.gridx = 5;
        formulario.add(clienteCpf, gbc);

        //--------------Produto-----------------//
        gbc.gridx = 0; gbc.gridy = 3;
        formulario.add(produtoId, gbc);

        gbc.gridx = 1;
        formulario.add(produtoNome, gbc);

        gbc.gridx = 2;
        formulario.add(produtoPreco, gbc);

        gbc.gridx = 3;
        formulario.add(produtoQnt, gbc);

        gbc.gridx = 4; gbc.gridy = 5;
        formulario.add(descontoField, gbc);

        gbc.gridx = 5;
        formulario.add(acrescimoField, gbc);

        gbc.gridx=4; gbc.gridy=6;
        formulario.add(totalLabel, gbc);
        //---------------------------//

        JPanel botoes = new JPanel(new GridLayout(1,6,10,0));

        JButton buscar = new JButton("Buscar ID");
        JButton salvarCliente = new JButton("Salvar Cliente");
        JButton buscarCliente = new JButton("Buscar Cliente");
        JButton salvar = new JButton("Salvar Produto");
        JButton limpar = new JButton("Limpar Campos");
        JButton atualizarTotal = new JButton("Ajustar Total de preços");

        botoes.add(salvarCliente);
        botoes.add(buscarCliente);
        botoes.add(buscar);
        botoes.add(salvar);
        botoes.add(limpar);
        botoes.add(atualizarTotal);

        salvarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Cliente c = new Cliente(
                            Integer.parseInt(clienteId.getText()),
                            clienteNome.getText(),
                            clienteEndereco.getText(),
                            clienteTelefone.getText(),
                            clienteEmail.getText(),
                            clienteCpf.getText()
                    );
                    int idInformado = Integer.parseInt(clienteId.getText());
                    boolean existe = false;

                    for (Cliente cliente : listaCliente) {
                        if (cliente.getIdCliente() == idInformado) {
                            existe = true;
                            break;
                        }
                    }

                    if (existe) {
                        JOptionPane.showMessageDialog(null, "Já existe Cliente com esse ID.");
                    } else {
                        listaCliente.add(c);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Preencha ID, telefone e CPF do cliente apenas com numeros.",
                            "Dados invalidos",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        buscarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idCliente = Integer.parseInt(clienteId.getText());

                    for(Cliente c : listaCliente){
                        if(c.getIdCliente() == idCliente){
                            clienteNome.setText(c.getNome());
                            clienteEndereco.setText(c.getEndereco());
                            clienteTelefone.setText(c.getTelefone());
                            clienteEmail.setText(c.getEmail());
                            clienteCpf.setText(c.getCnpj_Cpf());
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Digite um ID de cliente valido para buscar.",
                            "Dados invalidos",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        buscar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(produtoId.getText());

                    for (Produto p : lista) {
                        if (p.getId() == id) {
                            produtoNome.setText(p.getNome());
                            produtoPreco.setText(Float.toString(p.getPreco()));
                            produtoQnt.setText(Integer.toString(p.getQnt()));
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Digite um ID de produto valido para buscar.",
                            "Dados invalidos",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

            }

        });

        salvar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Produto p = new Produto(
                            Integer.parseInt(produtoId.getText()),
                            produtoNome.getText(),
                            Float.parseFloat(produtoPreco.getText()),
                            Integer.parseInt(produtoQnt.getText())
                    );
                    int idInformado = Integer.parseInt(produtoId.getText());
                    boolean existe = false;

                    for (Produto item : lista) {
                        if (item.getId() == idInformado) {
                            existe = true;
                            break;
                        }
                    }

                    if (existe) {
                        JOptionPane.showMessageDialog(null, "Já existe produto com esse ID.");
                    } else {
                        lista.add(p);
                    }

                    totalLabel.setText("Total de preços produtos: R$" + calcularTotalBase());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Preencha ID, preco e quantidade do produto com numeros validos.",
                            "Dados invalidos",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }

        });

        atualizarTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    float totalBase = calcularTotalBase();
                    float desconto = 0;
                    float acrescimo = 0;

                    if(!descontoField.getText().isEmpty()){
                        desconto = Float.parseFloat(descontoField.getText());
                        totalBase -= desconto;
                    }

                    if(!acrescimoField.getText().isEmpty()){
                        acrescimo = Float.parseFloat(acrescimoField.getText());


                    }
                    totalBase += acrescimo;
                    totalBase -= desconto;

                    float totalFinal = totalBase;
                    if(totalFinal < 0){
                        JOptionPane.showMessageDialog(null, "O total nao pode ficar negativo.");
                    }else {
                        totalLabel.setText("Total de preços produtos: R$" + totalFinal);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Digite desconto e acrescimo usando numeros validos.",
                            "Dados invalidos",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        limpar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                clienteId.setText("");
                clienteNome.setText("");
                clienteEndereco.setText("");
                clienteTelefone.setText("");
                clienteEmail.setText("");
                clienteCpf.setText("");
                produtoId.setText("");
                produtoNome.setText("");
                produtoPreco.setText("");
                produtoQnt.setText("");
            }

        });

        principal.add(formulario, BorderLayout.CENTER);
        principal.add(botoes, BorderLayout.SOUTH);
        add(principal);

        setTitle("Cadastro de Orcamento");
        setSize(900,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
