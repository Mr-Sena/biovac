import { vacina } from "./vacina"

export class user {
    public id: number
    public nome: string
    public email: string
    public cpf: string
    public birthday: string
    public vacinacao: vacina[]
}