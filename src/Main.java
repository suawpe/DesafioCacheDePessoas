void main() {

    List<Pessoa> banco = new ArrayList<>();
    List<Pessoa> cache = new ArrayList<>();

    banco.add(new Pessoa(1, "Ana Banana", 25));
    banco.add(new Pessoa(2, "Bruno Bomba", 30));
    banco.add(new Pessoa(3, "Carla Mambra", 22));
    banco.add(new Pessoa(4, "Diego Limeira", 41));
    banco.add(new Pessoa(5, "Elisa Lima", 35));

    Scanner sc = new Scanner(System.in);

    IO.print("1-buscar  2-cadastrar  3-quantidade  0-sair: ");
    int opcao = sc.nextInt();

    while (opcao != 0) {

        if (opcao == 1) {
            IO.print("ID para buscar: ");
            int idDigitado = sc.nextInt();
            boolean achou = false;

            for (Pessoa p : cache) {
                if (p.id == idDigitado) {
                    IO.println("pessoa encontrada no cache: " + p);
                    achou = true;
                }
            }

            if (!achou) {
                for (Pessoa p : banco) {
                    if (p.id == idDigitado) {
                        if (cache.size() == 10) cache.remove(0);
                        cache.add(p);
                        IO.println("pessoa buscada no banco e adicionada ao cache: " + p);
                        achou = true;
                    }
                }
            }

            if (!achou) IO.println("pessoa não encontrada.");
        }

        if (opcao == 2) {
            IO.print("ID: ");
            int id = sc.nextInt();
            IO.print("nome: ");
            String nome = sc.next();
            IO.print("idade: ");
            int idade = sc.nextInt();

            boolean existe = false;

            for (Pessoa p : banco) {
                if (p.id == id) existe = true;
            }

            if (existe) {
                IO.println("já existe uma pessoa com esse ID.");
            } else {
                banco.add(new Pessoa(id, nome, idade));
                IO.println("pessoa cadastrada no banco.");
            }
        }

        if (opcao == 3) {
            IO.println("pessoas no banco: " + banco.size());
            IO.println("pessoas no cache: " + cache.size());
        }

        IO.print("1-buscar  2-cadastrar  3-quantidade  0-sair: ");
        opcao = sc.nextInt();
    }
}