drop procedure if exists my_proc

create procedure my_proc(@id varchar(36), @asset char(10), @qty numeric)
as
begin
    begin try
        begin
            transaction t
            insert into ids (id) values (@id);
            exec ins_trans @asset = @asset, @qty = @qty, @ex_id = @id
        commit transaction
        select error_number()    as error_number,
               error_state()     as error_state,
               error_severity()  as error_severity,
               error_procedure() as error_procedure,
               error_line()      as error_line,
               error_message()   as error_messagee
    end try
    begin catch
        rollback transaction
        select error_number()    as error_number,
               error_state()     as error_state,
               error_severity()  as error_severity,
               error_procedure() as error_procedure,
               error_line()      as error_line,
               error_message()   as error_messagee
    end catch
end

go
