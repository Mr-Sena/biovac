import { Component, OnInit } from '@angular/core';
import { User } from '../model/User';
import { Vacina } from '../model/Vacina';
import { CadastroService } from '../service/cadastro.service';

@Component({
  selector: 'app-main-frame',
  templateUrl: './main-frame.component.html',
  styleUrls: ['./main-frame.component.css']
})
export class MainFrameComponent implements OnInit {

  usuario: User = new User
  usuarioNull: User = new User

  vacinacao: Vacina = new Vacina
  vacinacaoNull: Vacina = new Vacina

  idUser = { id: 0 }
  
  

  verifica: string
  nome : boolean
  email: boolean
  cpf: boolean
  data: boolean

  
  identificadores: number[] = []


  constructor(
    private cadastramento: CadastroService
    ) { }

  
  ngOnInit() {
    window.scroll(0 ,0)
    console.log(this.vacinacao)

  }

  //Métodos para cadastar usuário
  cadastrar() {
    if (this.nome && this.email && this.cpf && this.data) {
      this.cadastramento.user(this.usuario).subscribe((resp: User) => {
        this.usuario = resp
        alert(`Usuario cadastrado com sucesso, portando o Id ${this.usuario.id}`)
        //this.identificadores.push(this.usuario.id)
        this.usuario = this.usuarioNull
      }, erro => {
        if(erro.status == 400) {
          alert('CPF ou E-mail ja cadastrado!')
        }
      })
    } else if (!this.nome) {
      alert('Preencha o nome!')
    } else if (!this.email) {
      alert('Preencha o email!')
    } else if (!this.cpf) {
      alert('Preencha o CPF!')
    } else if (!this.data) {
      alert('Preencha a data de aniversário corretamente!')
    }
  }

  verificaNome(event: any) {
    if(event.target.value == '' || event.target.value == ' ' || event.target.value == null) {
      this.nome = false
    } else {
      this.nome = true
    }
    this.verify()
  }

  verificaEmail(event: any) {
    if (event.target.value == '' || event.target.value == ' ') {
      this.email = false
    } else {
      this.email = true
    }
    this.verify()
  }

  verificaCpf(event: any) {
    if (event.target.value == '' || event.target.value == ' ') {
      this.cpf= false
    } else {
      this.cpf = true
    }
    this.verify()
  }

  verificaData (event: any) {
    if (event.target.value == '' || event.target.value == ' ') {
      this.data = false
    } else {
      this.data = true
    }
    this.verify()
  }

  verify() {
    if (!this.nome || !this.email || !this.cpf || !this.data) {
      this.verifica = '* Os campo acima não pode estar vazio'
    } else
    this.verifica = ''
  }

  //Métodos para cadastar usuário -FIM

  //Metodos para cadastrar a aplicação da vacína

  vacinar() {
    this.cadastramento.vacinada(this.vacinacao).subscribe((resp: Vacina) => {
      this.vacinacao = resp
      alert('Vacinação cadastrada')
      this.vacinacao = this.vacinacaoNull
    })
  }

}
