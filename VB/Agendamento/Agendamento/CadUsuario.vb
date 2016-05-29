Imports MySql.Data.MySqlClient

Public Class CadUsuario

    Dim id_user As String = ""

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click

        If txtNome.Text = "" Then
            MsgBox("Favor, preencher o campo nome.", MsgBoxStyle.Information)
        ElseIf txtEmail.Text = "" Then
            MsgBox("Favor, preencher o campos e-mail.", MsgBoxStyle.Information)
        ElseIf txtSenha.Text = "" Then
            MsgBox("Favor, preencher o campo senha.", MsgBoxStyle.Information)
        Else
            objconn = New MySqlConnection
            objconn.ConnectionString = "server='localhost';user='root';password='MySQL';database='agendamento';"
            objconn.Open()

            Dim nome As String = txtNome.Text
            Dim telefone As String = txtTelefone.Text
            Dim cpf As String = txtCpf.Text
            Dim email As String = txtEmail.Text
            Dim senha As String = txtSenha.Text
            Dim tipo_usuario As String = cbTipoUsuario.Text

            Dim tp_user As Integer
            If (tipo_usuario = "Aluno") = True Then
                tp_user = 0
            ElseIf (tipo_usuario = "Funcionário") = True Then
                tp_user = 1
            End If

            Try
                objcmd = New MySql.Data.MySqlClient.MySqlCommand("INSERT INTO usuario (nm_usuario,tel_usuario,cpf_usuario,email_usuario,senha_usuario,tipo_usuario) VALUES (@field1,@field2,@field3,@field4,@field5,@field6)", objconn)
                With objcmd
                    .Parameters.AddWithValue("@field1", nome)
                    .Parameters.AddWithValue("@field2", telefone)
                    .Parameters.AddWithValue("@field3", cpf)
                    .Parameters.AddWithValue("@field4", email)
                    .Parameters.AddWithValue("@field5", senha)
                    .Parameters.AddWithValue("@field6", tp_user)
                End With
                objcmd.ExecuteNonQuery()
                objcmd.Dispose()
                MsgBox("Cadastro efetuado com sucesso!", MsgBoxStyle.Information)
                limparCampos()
                carregarLista()
            Catch ex As Exception
                MsgBox("Erro")
            End Try
        End If
    End Sub

    Public Sub limparCampos()
        txtNome.Text = ""
        txtTelefone.Text = ""
        txtCpf.Text = ""
        txtEmail.Text = ""
        txtSenha.Text = ""
        cbTipoUsuario.Text = "Aluno"
    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        limparCampos()
    End Sub

    Private Sub CadastroDeHorárioToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles CadastroDeHorárioToolStripMenuItem.Click
        Login.Show()
        Me.Hide()
    End Sub

    Private Sub SairToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles SairToolStripMenuItem.Click
        Application.Exit()
    End Sub

    Private Sub CadUsuario_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        carregarLista()
    End Sub

    Public Sub carregarLista()
        objconn = New MySqlConnection
        objconn.ConnectionString = "server='localhost';user='root';password='MySQL';database='agendamento';"

        Dim stm As String = "SELECT * FROM usuario ORDER BY id_usuario"

        Try

            Dim cmd As MySqlCommand = New MySqlCommand(stm, objconn)
            Dim adpter As MySqlDataAdapter = New MySqlDataAdapter(cmd)

            Dim datatable As DataTable = New DataTable
            adpter.Fill(datatable)
            DataGridView1.DataSource = datatable


        Catch ex As MySqlException

        End Try
    End Sub

    Private Sub Button3_Click(sender As Object, e As EventArgs) Handles Button3.Click

        If txtNome.Text = "" Then
            MsgBox("Favor, preencher o campo nome.", MsgBoxStyle.Information)
        ElseIf txtEmail.Text = "" Then
            MsgBox("Favor, preencher o campos e-mail.", MsgBoxStyle.Information)
        ElseIf txtSenha.Text = "" Then
            MsgBox("Favor, preencher o campo senha.", MsgBoxStyle.Information)
        Else
            objconn = New MySqlConnection
            objconn.ConnectionString = "server='localhost';user='root';password='MySQL';database='agendamento';"
            objconn.Open()

            Dim nome As String = txtNome.Text
            Dim telefone As String = txtTelefone.Text
            Dim cpf As String = txtCpf.Text
            Dim email As String = txtEmail.Text
            Dim senha As String = txtSenha.Text
            Dim tipo_usuario As String = cbTipoUsuario.Text

            Dim tp_user As Integer
            If (tipo_usuario = "Aluno") = True Then
                tp_user = 0
            ElseIf (tipo_usuario = "Funcionário") = True Then
                tp_user = 1
            End If

            Try

                objcmd = New MySql.Data.MySqlClient.MySqlCommand("UPDATE usuario SET nm_usuario = @field1, tel_usuario = @field2, cpf_usuario = @field3, email_usuario = @field4, senha_usuario = @field5, tipo_usuario = @field6 WHERE id_usuario = @field7", objconn)
                With objcmd
                    .Parameters.AddWithValue("@field1", nome)
                    .Parameters.AddWithValue("@field2", telefone)
                    .Parameters.AddWithValue("@field3", cpf)
                    .Parameters.AddWithValue("@field4", email)
                    .Parameters.AddWithValue("@field5", senha)
                    .Parameters.AddWithValue("@field6", tp_user)
                    .Parameters.AddWithValue("@field7", id_user)
                End With
                objcmd.ExecuteNonQuery()
                objcmd.Dispose()
                MsgBox("Usuário atualizado com sucesso!", MsgBoxStyle.Information)
                limparCampos()
                carregarLista()
            Catch ex As Exception
                MsgBox("Erro")
            End Try
        End If
    End Sub

    Private Sub DataGridView1_CellContentClick(sender As Object, e As DataGridViewCellEventArgs) Handles DataGridView1.CellContentClick
        id_user = DataGridView1.CurrentRow.Cells(0).Value
        Dim nome As String = DataGridView1.CurrentRow.Cells(1).Value
        Dim telefone As String = DataGridView1.CurrentRow.Cells(2).Value
        Dim cpf As String = DataGridView1.CurrentRow.Cells(3).Value
        Dim email As String = DataGridView1.CurrentRow.Cells(4).Value
        Dim senha As String = DataGridView1.CurrentRow.Cells(5).Value
        Dim tipo As String = DataGridView1.CurrentRow.Cells(6).Value

        txtNome.Text = nome
        txtTelefone.Text = telefone
        txtCpf.Text = cpf
        txtEmail.Text = email
        txtSenha.Text = senha

        If tipo = "1" Then
            cbTipoUsuario.Text = "Funcionário"
        ElseIf tipo = "0" Then
            cbTipoUsuario.Text = "Aluno"
        End If

    End Sub

    Private Sub Button4_Click(sender As Object, e As EventArgs) Handles Button4.Click
        objconn = New MySqlConnection
        objconn.ConnectionString = "server='localhost';user='root';password='MySQL';database='agendamento';"
        objconn.Open()

        Try
            objcmd = New MySql.Data.MySqlClient.MySqlCommand("DELETE FROM usuario WHERE id_usuario = @field1", objconn)
            With objcmd
                .Parameters.AddWithValue("@field1", id_user)
            End With
            objcmd.ExecuteNonQuery()
            objcmd.Dispose()
            MsgBox("Usuário removido com sucesso!", MsgBoxStyle.Information)
            limparCampos()
            carregarLista()
        Catch ex As Exception
            MsgBox("Erro")
        End Try
    End Sub
End Class
