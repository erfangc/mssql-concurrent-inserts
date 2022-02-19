drop procedure if exists ins_trans

create procedure ins_trans(@asset varchar(36), @qty numeric, @ex_id varchar(36))
as
begin
    begin tran
        insert into transactions (asset, qty, ex_id) values (@asset, @qty, @ex_id);
        update positions set positions.qty = positions.qty + @qty where asset = @asset
        if @@ROWCOUNT = 0
            begin
                insert into positions (asset, qty) values (@asset, @qty);
            end
    commit tran
end

go