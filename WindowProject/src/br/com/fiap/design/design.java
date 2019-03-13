package br.com.fiap.design;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

import br.com.fiap.loja.bo.EstoqueBOStub;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultaBO;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultaBOResponse;
import br.com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

public class design {

	protected Shell shlConsultarLoja;
	private Text text;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			design window = new design();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlConsultarLoja.open();
		shlConsultarLoja.layout();
		while (!shlConsultarLoja.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlConsultarLoja = new Shell();
		shlConsultarLoja.setSize(247, 235);
		shlConsultarLoja.setText("Consultar Loja");

		Button btnNewButton = new Button(shlConsultarLoja, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override

			// então, aqui no widgetSelected eu joguei o consultar da classe consultar
			// estoque para apresentar na tela, tive que usar
			// o try catch pra retornar um erro caso o numero digitado não for igual a do
			// estoque

			public void widgetSelected(SelectionEvent e) {
				try {
					EstoqueBOStub stub = new EstoqueBOStub();
					ConsultaBO consultar = new ConsultaBO();
					consultar.setCodProd(Integer.parseInt(text.getText()));
					ConsultaBOResponse response = stub.consultaBO(consultar);
					ProdutoTO produto = response.get_return();
					MessageDialog.openInformation(null, "Camiseta encontrada!", produto.getDescricao());
				} catch (Exception e2) {
					MessageDialog.openInformation(null, "Camiseta encontrada!", "Error");
				}

			}
		});

	
		btnNewButton.setFont(SWTResourceManager.getFont("Segoe UI Semilight", 9, SWT.ITALIC));
		btnNewButton.setBounds(58, 87, 105, 21);
		btnNewButton.setText("Consultar");

		text = new Text(shlConsultarLoja, SWT.BORDER);
		text.setBounds(38, 49, 155, 21);
		
		Label lblDigiteONumero = new Label(shlConsultarLoja, SWT.NONE);
		lblDigiteONumero.setBounds(38, 28, 155, 15);
		lblDigiteONumero.setText("Digite o numero da camisa");

	}
}
