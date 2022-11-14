package br.com.rd.ved.service;



public class PedidoService {
	
//	private final PedidoRepository pedidoRepository;
//	private final ClienteRepository clienteRepository;
//	private final CupomDescontoRepository cupomDescontoRepository;
//	private final PedidoStatusRepository pedidoStatusRepository;
//	private final FreteRepository freteRepository;
//	private final EnderecoRepository enderecoRepository;
//	
//	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//	private Boolean sistema = true;
//			
//	public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository,
//			CupomDescontoRepository cupomDescontoRepository, PedidoStatusRepository pedidoStatusRepository,
//			FreteRepository freteRepository, EnderecoRepository enderecoRepository) {
//		super();
//		this.pedidoRepository = pedidoRepository;
//		this.clienteRepository = clienteRepository;
//		this.cupomDescontoRepository = cupomDescontoRepository;
//		this.pedidoStatusRepository = pedidoStatusRepository;
//		this.freteRepository = freteRepository;
//		this.enderecoRepository = enderecoRepository;
//	}
//
//	public void iniciar(Scanner sc) throws ParseException {
//		int acao;
//
//		while (sistema) {
//			System.out.println("Qual a ação que será realizada em pedido");
//			System.out.println("0 - Sair");
//			System.out.println("1 - Salvar");
//			System.out.println("2 - Atualizar");
//			System.out.println("3 - Visualizar");
//			System.out.println("4 - Deletar");
//
//			acao = Integer.parseInt(sc.nextLine());
//
//			switch (acao) {
//			case 1:
//				salvar(sc);
//				break;
//			case 2:
//				atualizar(sc);
//				break;
//			case 3:
//				visualizar();
//				break;
//			case 4:
//				deletar(sc);
//				break;
//			default:
//				sistema = false;
//				break;
//			}
//		}
//	}
//
//	private void salvar(Scanner sc) throws ParseException {
//		
//		System.out.println("Informe a data do Pedido (dd/MM/yyyy)");
//		String dt = sc.nextLine();
//		Date dataPedido = formato.parse(dt);
//				
//		System.out.println("Digite o ID do Cliente para Pedido:");
//		Integer clienteId = Integer.parseInt(sc.nextLine());
//		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
//
//		System.out.println("Digite o ID do Cupom Desconto para Pedido:");
//		Integer cupomDescontoId = Integer.parseInt(sc.nextLine());
//		Optional<CupomDesconto> cupomDesconto = cupomDescontoRepository.findById(cupomDescontoId);
//		
//		System.out.println("Digite o ID do Status do Pedido para Pedido:");
//		Integer pedidoStatusId = Integer.parseInt(sc.nextLine());
//		Optional<PedidoStatus> pedidoStatus = pedidoStatusRepository.findById(pedidoStatusId);
//		
//		System.out.println("Digite o ID do Frete para Pedido:");
//		Integer freteId = Integer.parseInt(sc.nextLine());
//		Optional<Frete> frete = freteRepository.findById(freteId);
//		
//		System.out.println("Digite o ID do Endereco para Pedido:");
//		Integer enderecoId = Integer.parseInt(sc.nextLine());
//		Optional<Endereco> endereco = enderecoRepository.findById(enderecoId);
//				
//		Pedido pedido = new Pedido(dataPedido, cliente.get(), cupomDesconto.get(), pedidoStatus.get(), frete.get(), endereco.get());
//		pedidoRepository.save(pedido);
//		System.out.println("Pedido Salvo com Sucesso");
//
//	}
//
//	private void atualizar(Scanner sc) throws ParseException {
//		System.out.println("Informe o ID do Pedido a ser atualizado:");
//		Integer id = Integer.parseInt(sc.nextLine());
//		
//		System.out.println("Informe a data do Pedido (dd/MM/yyyy)");
//		String dt = sc.nextLine();
//		Date dataPedido = formato.parse(dt);
//		
//		System.out.println("Digite o ID do Cliente para Pedido:");
//		Integer clienteId = Integer.parseInt(sc.nextLine());
//
//		System.out.println("Digite o ID do Cupom Desconto para Pedido:");
//		Integer cupomDescontoId = Integer.parseInt(sc.nextLine());
//		
//		System.out.println("Digite o ID do Status para Pedido:");
//		Integer pedidoStatusId = Integer.parseInt(sc.nextLine());
//		
//		System.out.println("Digite o ID do Frete para Pedido:");
//		Integer freteId = Integer.parseInt(sc.nextLine());
//		
//		System.out.println("Digite o ID do Endereco para Pedido:");
//		Integer enderecoId = Integer.parseInt(sc.nextLine());
//
//		Optional<Pedido> pedido = pedidoRepository.findById(id);
//		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
//		Optional<CupomDesconto> cupomDesconto = cupomDescontoRepository.findById(cupomDescontoId);
//		Optional<PedidoStatus> pedidoStatus = pedidoStatusRepository.findById(pedidoStatusId);
//		Optional<Frete> frete = freteRepository.findById(freteId);
//		Optional<Endereco> endereco = enderecoRepository.findById(enderecoId);
//		pedido.get().setData(dataPedido);
//		pedido.get().setCliente(cliente.get());
//		pedido.get().setCupomDesconto(cupomDesconto.get());
//		pedido.get().setPedidoStatus(pedidoStatus.get());
//		pedido.get().setFrete(frete.get());
//		pedido.get().setEnderecos(endereco.get());
//		pedidoRepository.save(pedido.get());
//		System.out.println("Pedido Alterado com Sucesso");
//	}
//
//	private void visualizar() {
//		Iterable<Pedido> pedido = pedidoRepository.findAll();
//		pedido.forEach(f -> System.out.println(f));
//	}
//
//	private void deletar(Scanner sc) {
//		System.out.println("Digite o ID do Pedido");
//		Integer id = Integer.parseInt(sc.nextLine());
//		freteRepository.deleteById(id);
//		System.out.println("Pedido Deletado com Sucesso");
//	}
}
