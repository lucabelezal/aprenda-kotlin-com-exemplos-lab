fun main() {
    val kotlinBasico = ConteudoEducacional("Kotlin Básico", nivel = Nivel.BASICO)
    val kotlinIntermediario = ConteudoEducacional("Kotlin Intermediário", 120, nivel = Nivel.INTERMEDIARIO)
    val kotlinDificil = ConteudoEducacional("Kotlin Avançado", 40, nivel = Nivel.DIFICIL)


    val formacaoKotlin = Formacao(
        "Formação Kotlin",
        listOf(kotlinBasico, kotlinIntermediario, kotlinDificil)
    )

    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")

    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    formacaoKotlin.listarInscritos()
}

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class ConteudoEducacional(
    var nome: String,
    val duracao: Int = 60,
    val nivel: Nivel
)

data class Usuario(val nome: String)

data class Formacao(
    val nome: String,
    var conteudos: List<ConteudoEducacional>
) {

    private val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("Usuário ${usuario.nome} matriculado na formação $nome.")
        } else {
            println("Usuário ${usuario.nome} já está matriculado na formação $nome.")
        }
    }

    fun listarInscritos() {
        println("Lista de inscritos na formação $nome:")
        for (usuario in inscritos) {
            println(usuario.nome)
        }
    }

}