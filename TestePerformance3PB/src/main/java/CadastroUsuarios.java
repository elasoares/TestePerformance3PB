import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CadastroUsuarios {
        private String idUsuario;
        private String nomeCompleto;
        private String email;
        private String senha;
        private String dataNascimento;
        private String genero;

        @Override
        public String toString() {
                return "Informações do usuário: "  +
                        "Id: " + idUsuario  +
                        ", Nome Completo: " + nomeCompleto +
                        ", Email: " + email +
                        ", Senha: " + senha  +
                        ", Data de nascimento: " + dataNascimento +
                        ", Gênero: " + genero;
        }
}
